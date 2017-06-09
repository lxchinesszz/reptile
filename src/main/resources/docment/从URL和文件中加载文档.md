### 从URL加载文档

[从URL加载文档](https://jsoup.org/cookbook/input/load-document-from-url)

##### `使用Jsoup.connect(String url)方法：`

这种方法只支持Web URL（http和https协议）

```
Document doc = Jsoup.connect("http://example.com/").get();
String title = doc.title();


Document doc = Jsoup.connect("http://example.com")
  .data("query", "Java")
  .userAgent("Mozilla")
  .cookie("auth", "token")
  .timeout(3000)
  .post();
```

*您有一个包含相对URL的HTML文档，您需要将其解析为绝对URL*

- 确保base URI在解析文档时指定（在从URL加载时是隐式的）和
- 使用abs:属性前缀从属性中解析绝对URL：


```
Document doc = Jsoup.connect("http://jsoup.org").get();

Element link = doc.select("a").first();
String relHref = link.attr("href"); // == "/"
String absHref = link.attr("abs:href"); // "http://jsoup.org/"
```

_在HTML元素中，URL通常是相对于文档的位置写的：<a href="/download">...</a>。当您使用该Node.attr(String key)方法获取href属性时，它将按照源HTML中指定的方式返回。

如果要获取绝对URL，则会出现一个属性键前缀abs:，这将导致根据文档的基本URI（原始位置）解析属性值：attr("abs:href")

对于这种用例，重要的是在分析文档时指定基本URI。

如果你不想使用abs:前缀，还有一个方法Node.absUrl(String key)是做同样的事情，但是通过自然属性键访问。_






### 从文件中加载文档

[从文件中加载文档](https://jsoup.org/cookbook/input/load-document-from-file)

##### `Jsoup.parse(File in, String charsetName, String baseUri)`

```
File input = new File("/tmp/input.html");
Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
```