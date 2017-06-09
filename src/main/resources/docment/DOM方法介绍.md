### 使用DOM方法

[DOM方法](https://jsoup.org/cookbook/extracting-data/dom-navigation)

```
File input = new File("/tmp/input.html");
Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

Element content = doc.getElementById("content");
Elements links = content.getElementsByTag("a");
for (Element link : links) {
  String linkHref = link.attr("href");
  String linkText = link.text();
}

```

####描述
_元素提供了一系列类似DOM的方法来查找元素，并提取和操作其数据。DOM getter是上下文的：在父文档上调用它们找到文档下的匹配元素; 呼吁一个孩子元素，他们找到那个孩子的元素。以这种方式，您可以选择所需的数据。_

##### 寻找元素
- getElementById(String id)
- getElementsByTag(String tag)
- getElementsByClass(String className)
- getElementsByAttribute(String key) （和相关方法）
- 元素的兄弟姐妹：siblingElements()，firstElementSibling()，lastElementSibling()，nextElementSibling()，previousElementSibling()
- 图：parent()，children()，child(int index)

##### 元素数据
- attr(String key)获取和attr(String key, String value)设置属性
- attributes() 获取所有属性
- id()，className()和classNames()
- text()获取并text(String value)设置文本内容
- html()获取和html(String value)设置内部HTML内容
- outerHtml() 获取外部HTML值
- data()获取数据内容（例如script和style标签）
- tag() 和 tagName()

##### 操纵HTML和文本
- append(String html)， prepend(String html)
- appendText(String text)， prependText(String text)
- appendElement(String tagName)， prependElement(String tagName)
- html(String value)