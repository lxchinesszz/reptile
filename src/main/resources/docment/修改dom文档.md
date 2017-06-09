### 设置元素的HTML


[设置元素的HTML](https://jsoup.org/cookbook/modifying-data/set-html)

```
Element div = doc.select("div").first(); // <div></div>
div.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
div.prepend("<p>First</p>");
div.append("<p>Last</p>");
// now: <div><p>First</p><p>lorem ipsum</p><p>Last</p></div>

Element span = doc.select("span").first(); // <span>One</span>
span.wrap("<li><a href='http://example.com/'></a></li>");
// now: <li><a href="http://example.com"><span>One</span></a></li>


Element div = doc.select("div").first(); // <div></div>
div.text("five > four"); // <div>five &gt; four</div>
div.prepend("First ");
div.append(" Last");
// now: <div>First fi

```

#### 讨论

- Element.html(String html) 清除元素中的任何现有的内部HTML，并用解析的HTML替换它。
- Element.prepend(String first)并分别Element.append(String last)将HTML添加到元素内部HTML的开始或结尾
- Element.wrap(String around)围绕元素的外部 HTML 包装HTML 。

- Element.text(String text) 清除元素中的任何现有的内部HTML，并用提供的文本替换它。
- Element.prepend(String first)并分别Element.append(String last)将文本节点添加到元素内部HTML的开始或结尾

####也可以看看
您还可以使用Element.prependElement(String tag)和Element.appendElement(String tag)方法创建新元素并将其作为子元素插入到文档流中。