# Dorar.net java package

A package for working with dorar.net site. You can search,
and then with the package you can get:
1. raw of list (including html tags for each result)
2. text (without html tags in each result)
3. object with text and search_result boolean as attribute.

```java
class Main(){
    static void main(String[] args){
        Dorar dorar = new Dorar("يا أيها النبي");
        // this will return raw results
        dorar.getRawResults();
        // this will return text results
        dorar.getTextResults();
        // this will return parsed results
        dorar.getParsedResults();
    }
}
```