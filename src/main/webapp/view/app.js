var app = angular.module('app', ['ui.grid', 'ui.grid.pagination', 'ui.grid.grouping', 'ui.grid.edit', 'ui.grid.selection']);
var map;


app.controller('StudentCtrl', ['$scope', 'ZaakService', function ($scope, ZaakService) {
        var paginationOptions = {
            pageNumber: 1,
            pageSize: 15,
            sort: null
        };
        var columnDefs = [];
        ZaakService.getZaken(paginationOptions.pageNumber,
                paginationOptions.pageSize).success(function (data) {
                    
            startMap(data._embedded.zaaks[0].json_geometry.coordinates[0], data._embedded.zaaks[0].json_geometry.coordinates[1]);
            parseCoordinates(data._embedded.zaaks);
            $scope.gridOptions.data = data._embedded.zaaks;
            $scope.gridOptions.totalItems = data.page.totalElements;
            console.log("Setting headers");

            $.each(Object.keys(data._embedded.zaaks[0]), function (a, b) {
                if (b === ("jsonGeometry")) {
                    columnDefs.push({name: b, visible: false});

                } else {
                    if (!b.startsWith("_")) {
                        columnDefs.push({name: b});
                    }
                }
            });
            //$scope.gridOptions.columnDefs = columnDefs;


        });
//        ZaakService.getLocations().success(function (data) {
//
//        });
        function parseCoordinates(data) {
            $.each(data, function (a, b) {
                if(b.jsonGeometry !== null){
                    console.log("parsing coordinates");
                    var layer = new ol.layer.Vector({
                        source: new ol.source.Vector({
                            features: [
                                new ol.Feature({
                                    geometry: new ol.geom.Point(ol.proj.fromLonLat([b.json_geometry.coordinates[0], b.json_geometry.coordinates[1]]))
                                })
                            ]
                        })
                    });
                    map.addLayer(layer);                      
                }
               
            });
        }


        $scope.gridOptions = {
            paginationPageSizes: [15, 30, 50],
            paginationPageSize: paginationOptions.pageSize,
            enableColumnMenus: false,
            //useExternalPagination: true,
            enableFiltering: true,
            enableGridMenu: true,
            columnDefs: [
                {name: 'Naam'},
                {name: 'StrnmEnHuisnr'},
                {name: 'Gemeente'}
            ],
            onRegisterApi: function (gridApi) {
                $scope.gridApi = gridApi;
                gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
                    paginationOptions.pageNumber = newPage;
                    paginationOptions.pageSize = pageSize;
                    ZaakService.getZaken(newPage, pageSize).success(function (data) {
                        $scope.gridOptions.data = data._embedded.zaaks;
                        $scope.gridOptions.totalItems = data.page.totalElements;
                    });
                });
                gridApi.edit.on.afterCellEdit($scope, function (rowEntity, colDef, newValue, oldValue) {
                    ZaakService.editZaak(rowEntity);
                    console.log('Column: ' + colDef.name + ' rowEntity: ' + JSON.stringify(rowEntity) + ' new: ' + newValue + ' old: ' + oldValue);
                });
            }
        };



    }]);

app.service('ZaakService', ['$http', function ($http) {

        function getZaken(pageNumber, size) {
            //pageNumber = pageNumber > 0 ? pageNumber - 1 : 0;
            return  $http({
                method: 'GET',
                //   url: 'zaaks?projection=filtered&page=' + pageNumber + '&size=' + size
                url: '/zaaks/search/findBy'
            });
        }

        function getLocations() {
            return  $http({
                method: 'GET',
                url: '/zaaks/search/findBy'
            });
        }

        function editZaak(zaak) {
            console.log("editZaak()");
            //var data = JSON.stringify(zaak);
            $http({
                url: 'zaaks',
                method: "POST",
                contentType: "application/json",
                data: zaak
                //localhost:8080/zaaks/search/findByNaam?name=Ravage
            });

        }
        return {
            getZaken: getZaken,
            editZaak: editZaak,
            getLocations: getLocations
        };

    }]);