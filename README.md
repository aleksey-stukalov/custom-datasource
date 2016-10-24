# custom-datasource
This example illustrates how to create and use custom collection datasources in your CUBA Application.

The application combines two showcases:

1. Shows how to integrate 3rd party datasets, so for the example this application fetches data about currency rates through a collection datasource from [this resource](http://fixer.io/).
2. Demonstrates how to enable pagination over your custom datasource.

## Short Overview

### Integrating 3rd Party Data 
The _[CurrencyRate](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/global/src/com/company/customdatasource/entity/CurrencyRate.java)_ entity contains information about conversion rate between two currencies. The entity is not stored in the database, getting data through _[CurrencyService](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/global/src/com/company/customdatasource/service/CurrencyService.java)_.

_[CurrencyServiceBean](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/core/src/com/company/customdatasource/service/CurrencyServiceBean.java)_ implements _[CurrencyService](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/global/src/com/company/customdatasource/service/CurrencyService.java)_, parsing JSON response of the 3rd party service into a collection of _[CurrencyRate](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/global/src/com/company/customdatasource/entity/CurrencyRate.java)_ entities.

_[CurrencyRateDatasource](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/web/src/com/company/customdatasource/web/screens/customdatasources/CurrencyRateDatasource.java)_ wraps _[CurrencyService](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/global/src/com/company/customdatasource/service/CurrencyService.java)_ into a collection datasource to be able to use CUBA's standard mechanisms. As an example, this class is specified as a datasource class in _[currency-screen.xml](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/web/src/com/company/customdatasource/web/screens/currency-screen.xml#L10)_; so the main table of the screen is filled automatically according to the _[specified datasource](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/web/src/com/company/customdatasource/web/screens/currency-screen.xml#L28)_ . 

### Enabling Pagination
To enable pagination in your custom datasource you should implement _getEntities_ and _getCount_ methods, as it is shown in _[FooCollectionDatasource](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/web/src/com/company/customdatasource/web/screens/customdatasources/FooCollectionDatasource.java)_ and set a maximum nubmer of records to be returned in one page from [the screen controller](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/web/src/com/company/customdatasource/web/screens/FooScreen.java#L20), where this [datasource is used](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/web/src/com/company/customdatasource/web/screens/foo-screen.xml#L10). 

Based on CUBA Platform 6.3.1
