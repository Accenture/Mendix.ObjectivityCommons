# ObjectivityCommons
A toolset of useful Mendix stuff commonly shared between multiple projects like Java Actions and JavaScript Actions.

To use, export desired module from this project and export to your own.

Mendix version: 9.24.3.

## Table of Contents
[1. ObjectivityCommons](#1-ObjectivityCommons)

&nbsp;&nbsp;[1.1 ClientAPI](#11-clientapi)

&nbsp;&nbsp;[1.2 CSV](#12-csv)

&nbsp;&nbsp;[1.3 DataGrid](#13-datagrid)

&nbsp;&nbsp;[1.4 DOM](#14-dom)

&nbsp;&nbsp;[1.5 JSON](#15-json)

&nbsp;&nbsp;[1.6 List](#16-list)

&nbsp;&nbsp;[1.7 Misc](#17-misc)

&nbsp;&nbsp;[1.8 ORM](#18-orm)

&nbsp;&nbsp;[1.9 String](#19-string)

&nbsp;&nbsp;[1.10 URL](#110-url)

[2. TagSelector](#2-TagSelector)

[3. SignInMicroflow](#3-SignInMicroflow)

[4. DataMigration](#4-DataMigration)

## 1. ObjectivityCommons

### 1.1 ClientAPI

#### CurrentPageEquals_JS 

Checks whether current page name equals provided value.

#### CurrentSession_JS 

Retrieves current user session.

#### CurrentUserObject_JS 

Returns currentUser object cast to User entity without performing server call.

#### HasUserRole_JS 

This action checks whether current user has role with provided role name.

### 1.2 CSV

#### CSV_ReadNextLine_ToEntity

Safer alternative for ReadNextLine from CSV module.
This one is more safe:
the original one throws an exception if the result entity has more attributes than file columns.

Reads a next line from a CSV - and returns an entity of the configured type.
This action should only be invoked from the microflow used by a ImportCSV action.
If the action returns an empty entity, the end of the file is reached.

#### CSV_ReadNextLine_ToStringList

An alternative for ReadNextLine from CSV module.
This one is more dynamic:
doesn't require declaring a result entity with columns mapped as attributes.

Reads a next line from a CSV - and returns a List of StringDTO.
This action should only be invoked from the microflow used by a ImportCSV action.
If the action returns an empty list, the end of the file is reached.

#### CSV_WriteNextLine_FromEntity

Safer alternative for WriteNextLine from CSV module.
This one is more safe:
the original one throws an exception if the entity has more attributes than file columns.

Writes all (configured) attribute values from the entity as column values of CSV row.
This action should only be invoked from the microflow used by a ExportCSV action.
All attribute vales will be exported as Strings (using toString()); thus specific parsing should be part of the microflow.

#### CSV_WriteNextLine_FromStringList

An alternative for WriteNextLine from CSV module.
This one is more dynamic:
doesn't require declaring an entity with columns mapped as attributes.

Writes all values from the List of StringDTO as column values of CSV row.
This action should only be invoked from the microflow used by a ExportCSV action.

### 1.3 DataGrid

Tools for DataGrid 1.0 widget.

### 1.4 DOM

#### GetCaretPosition_JS

Gets current caret position in the edited text.

#### SetCaretPosition_JS

Sets current caret position in the edited text.

#### RemoveClassFromElements_JS

Removes class from elements with given selector.

#### SetInnerHTML_JS

Sets innerHTML attribute of HTML element.

#### RemoveFocusFromElement_JS

Removes focus from element with given selector

#### SetKeyboardNavigationOnListView_JS

Provides keyboard navigation events on list view items

### 1.5 JSON

#### JSON_Array_GetByKey

Generates a list of KeyValue objects from input JSON array. Each array element is represented as a single chosen attribute (key/value pair) mapped to Mendix object indexed with an order number. 

#### JSON_Array_GetKeyValuePairs

Generates a list of KeyValueContainer objects from input JSON array. Each array element is represented as a single KeyValueContainer object with associated collection of KeyValue objects. Each KeyValue object represents a single attribute (key/value pair) of its parent object. Additionally, the KeyValueContainer objects hold a single attribute ('id' recommended for most use cases) for easier identification. The attribute will be duplicated in the associated KeyValue object.

#### JSON_Object_GetByKey

Returns a string containing extracted value from provided JSON object.

#### JSON_Object_GetKeyValuePairs

Generates a list of attributes for provided JSON object as a KeyValue list.

#### JsonStringify_JS

See JavaScript: JSON.stringify

#### JsonStringifyList_JS

See JavaScript: JSON.stringify

### 1.6 List

#### ListDistinct

Returns copy of Input list with distinct values (for the given Attribute): duplicates are ignored.

#### ListMap

Maps source list into target list using simple get/set logic: get value from SourceAttribute (from source entity) and set it to TargetAttribute (to target entity).

#### ListShuffle

Expects list of Mendix Objects as a parameter and returns list of same elements with randomized order.

#### ListTake

Returns a sublist of a given list. Elements from start index (offset) to the end index (amount + offset) are taken. If offset is not given, then default value is assumed - 0. If the end index exceeds the bounds of the list, then all remaining elements are returned.

#### ListTake_JS

JS version of ListTake. Returns a sublist of a given list. Elements from start index (offset) to the end index (amount + offset) are taken. If offset is not given, then default value is assumed - 0. If the end index exceeds the bounds of the list, then all remaining elements are returned.

### 1.7 Misc

#### Logout

Logs out current user.

### 1.8 ORM

#### CloneIgnoreSystemAttributes

Clones objects fully - all attributes and associations

- Source: the original object to copy
- Target: the object to copy it into (should be of the same type, or a specialization)

System attributes are ignored.

#### CommitInSeparateDatabaseTransactionWithoutEvent

Copy of Community Commons commitInSeparateDatabaseTransation Java action. 

This action performs commit without events

#### GetAttributeValueAsString

Returns value of the named attribute for the provided object as a string.

#### GetTypeAsString

Enhanced version of CommunityCommons.getTypeAsString: ignoreModuleName param added.

Returns the actual type of an Entity. Useful as alternative way to split upon inheritance, or as input of other functions in this module.

#### RetrieveObjectByGuid

Retrieve an object of the provided type by GUID.

#### ExportOQLToJSON

Similiar to ExecuteOQLStatement, but returns data serialized in JSON format.

#### ExecuteSQLStatement

Allows execution of SQL Select statement in order to return MxObjects.

#### ExecuteSQLStatementReturnCount

Executes the SQL statement, which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; or an SQL statement that returns nothing, such as a DDL statement.

Returns either the row count for SQL Data Manipulation Language (DML) statements or 0 for SQL statements that return nothing.

#### RetrieveEnhanced

Similar to normal Retrieve (from DB) activity, enhanced with:
 - Simplified Pagination
 - Dynamic Sorting.

#### RetrieveEnhancedWithTotalRows

RetrieveEnhanced which returns total number of returned rows.

#### RetrieveFromList

Similiar to RetrieveEnhanced. Returns objects that are associated to objects from the source list.

#### RetrieveLong

Similiar to RetrieveEnhanced. Returns NumericValue objects for each selected object by XPath. Useful for Id retrieval.

### 1.9 String

#### StringBetween

Returns substring between OpeningTag and ClosingTag - or empty if >= 1 of tags is missing.

#### StringCount_JS

Counts number of occurences of Separator in the given input String.

#### StringJoin

See:
JamCommons: StringJoin
Java: String.join
JavaScript: Array.join

#### StringJoin_JS

See:
JamCommons: StringJoin
Java: String.join
JavaScript: Array.join

#### StringJoinByNF_JS

Same as StringJoin_JS, but getting the string value to join from each entity is different: calls the given NANOFLOW instead of an ATTRIBUTE. The nanoflow should accept the entity as param, and return string as result.

#### StringJoinByTemplate

Having example input List: [{Key:"id", Value:"1"}, {Key:"name", Value:"name1"}]
and Separator = ", "
and Template = "{Key}: {Value}"
result is: "id: 1, name: name1"

#### StringReplaceRegex

Full implementation of Java String.replaceAll()

Stronger then Mendix replaceAll/First() string functions: the replacement patterns are supported.

#### StringReplaceRegex_JS

Full implementation of JS String.replace()

Stronger then Mendix replaceAll/First() string functions: the replacement patterns are supported.

#### StringSplit

See:
CommunityCommons: StringSplit
JamCommons: StringSplit
Java: String.split
JavaScript: String.split

The splitting result is returned as list of StringValue objects.

#### StringSplit_JS

See:
CommunityCommons: StringSplit
JamCommons: StringSplit
Java: String.split
JavaScript: String.split

The splitting result is returned as list of StringValue objects.

### 1.10 URL

#### URLEncode

Mendix wrapper for Java for URLEncoder.encode method. Encodes in UTF-8 format.

See: https://docs.oracle.com/javase/8/docs/api/java/net/URLEncoder.html

#### URLOpen_JS

Opens the provided URL in the web browser.

## 2. TagSelector

Module with useful tools for [Tag Selector](https://marketplace.mendix.com/link/component/116854) widget.

## 3. SignInMicroflow

Module that is an extension of [SignIn microflow](https://marketplace.mendix.com/link/component/66443) widget. This extension adds two separate microflows:
- SignIn_Before: called AFTER user provides credentials and clicks Sign-in button, but BEFORE triggering sign-in logic. It is a good place e.g. for Accounts provisioning.
- SignIn_After: called when anonymous user signs in.
Currently, both MFs do nothing but logging, but you can overwrite their content.

## 4. DataMigration

This module provides management for data migrations often required during development.
