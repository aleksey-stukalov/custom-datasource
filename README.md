# custom-datasource
This example illustrates how to create and use custom collection datasource in your CUBA Application.

For the example this application fetches data about currency rates through a collection datasource from [this resource](http://fixer.io/).

## Short Overview

The _[CurrencyRate](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/global/src/com/company/customdatasource/entity/CurrencyRate.java)_ entity contains information about conversion rate between two currencies. The entity is not stored in the database, getting data through _[CurrencyService](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/global/src/com/company/customdatasource/service/CurrencyService.java)_.

_[CurrencyServiceBean](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/core/src/com/company/customdatasource/service/CurrencyServiceBean.java)_ implements _[CurrencyService](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/global/src/com/company/customdatasource/service/CurrencyService.java)_, parsing JSON response of the 3rd party service into a collection of _[CurrencyRate](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/global/src/com/company/customdatasource/entity/CurrencyRate.java)_ entities.

_[CurrencyRateDatasource](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/web/src/com/company/customdatasource/web/screens/customdatasources/CurrencyRateDatasource.java)_ wraps _[CurrencyService](https://github.com/aleksey-stukalov/custom-datasource/blob/0770428e1cd87ff37a2632ac3c7105208c45b0f1/modules/global/src/com/company/customdatasource/service/CurrencyService.java)_ into a collection datasource to be able to use CUBA's standard mechanisms. As an example, this class is specified as a datasource class in _[currency-screen.xml](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/web/src/com/company/customdatasource/web/screens/currency-screen.xml#L10)_; so the main table of the screen is filled automatically according to the _[specified datasource](https://github.com/aleksey-stukalov/custom-datasource/blob/master/modules/web/src/com/company/customdatasource/web/screens/currency-screen.xml#L28)_ . 

Based on CUBA Platform 6.3.0.RC2
