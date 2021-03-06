/**
 * 
 */
/*jshint sub:true*/
' use strict';

var isDebug = false;
var DEBUG = function (val) {
    if (isDebug) {
        
      
    }
};
var ERROR = function (val) {
   
};

var LOG = function (val) {
  
   
};


var ServerTableFetch = function (url, http, callBackBefore,
    callBackAfter, callBackAfterError) {

    this.url = url;
    this.http = http;
    this.callBackBefore = callBackBefore;
    this.callBackAfter = callBackAfter;
    this.callBackAfterError = callBackAfterError;


    this.process = function (tableState) {

        (tableState);
        this.callBackBefore("CALL BACK BEFORE");


        if (angular.isFunction(this.url)) {
            this.urlValue = this.url(tableState);
        }

        if (this.urlValue === '') {
            this.callBackAfterError("no Fetch");
            return;
        }

        var pagination = tableState.pagination;
        var page = (pagination.start / pagination.number) || 0;
        var size = pagination.number || 10;
        var sort = (tableState.sort.predicate) ? tableState.sort.predicate : "";
        var sortDirection = (tableState.sort.reverse) ? "asc" : "desc";
        var searchParamsValue = "";
        var searchParamsKey = "";

        if (!tableState.search.predicateObject) {
            tableState.search.predicateObject = {};
        }
        if (tableState.search.predicateObject) {
            if (typeof(tableState.search.predicateObject["code"])!=="undefined" && tableState.search.predicateObject["code"]!==null)
                 var code = tableState.search.predicateObject["code"];
                 if (typeof(tableState.search.predicateObject["name"])!=="undefined" &&  tableState.search.predicateObject["name"]!==null)
                var name = tableState.search.predicateObject["name"];
        }
        if (tableState.sort.predicate) {
            switch(tableState.sort["predicate"]){
              case "code":
              case "CODE":
                            var revOrder = (tableState.sort.reverse)? 1 : -1;
                            break;
              case "name":
              case "NAME":
                            var revOrder1 = (tableState.sort.reverse)? 1 : -1;
                            break;


            }
            


        }
        var query = {
        	perPage:1,
            limit:10,
            orderBy:"trainNo"
           
        };

        this.http.get(url, { params: query })
            .then(function (response) {

                var resultObj = response.data;
                tableState.pagination.numberOfPages = response.data.last;
                tableState.pagination.totalItemCount = response.data.count;
                resultObj.tableState = tableState;
                this.callBackAfter(resultObj);
            }.bind(this),
            function (response) {
                if (this.callBackAfterError) {
                    this.callBackAfterError(response);
                }
            }.bind(this));

    }.bind(this);
};

ServerTableFetch.prototype = {
    url: null,
    
    searchItems: null,
    resultObj: null,
    processFunction: null,
    callBack: null
};