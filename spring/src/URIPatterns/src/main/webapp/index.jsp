<html>
<head>
    <style>
        a{
            margin-left: 5px;
            margin-right: 5px;
        }
    </style>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script>
        function postNoneJson() {
            var data = {"name": "pig","age":10};
            $.ajax({
                type: "POST",
                url: "/narrow/pets0",
                data: data,
                success: function (message) {
                    if (message > 0) {
                        alert(JSON.stringify(message));
                    }
                },
                error: function (message) {
                    alert(JSON.stringify(message));
                }
            });
        }

        function postJson() {
            var data = {"name": "pig","age":10};
            $.ajax({
                type: "POST",
                url: "/narrow/pets0",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (message) {
                    if (message > 0) {
                        alert(JSON.stringify(message));
                    }
                },
                error: function (message) {
                    alert(JSON.stringify(message));
                }
            });
        }

        function postJson2() {
            var data = {"name": "pig","age":10};
            $.ajax({
                type: "POST",
                url: "/narrow/pets3/2",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (message) {
                    if (message > 0) {
                        alert(JSON.stringify(message));
                    }
                },
                error: function (message) {
                    alert(JSON.stringify(message));
                }
            });
        }
    </script>
</head>
<body>
<h1>According to headers/params/input/output, Narrow request.</h1>
<h2>The basic demos</h2>
<hr>
<a href="/basic/simple">SimpleGet</a>
<a href="/basic/path/whatcanIdo">PathValue</a>
<a href="/basic/path2/You/mid/too">PathValueTwo</a>
<a href="/basic/spring-web-3.0.5.jar">Regex</a>

<h2>Limit Input/Output</h2>
<hr>
<a onclick="postNoneJson()">Consumes Limit(Json Input)</a>
<a onclick="postJson()">Available Consumes Limit(Json Input)</a>
<a href="/narrow/pets1_1/23">Produces Limit(Json output)</a>
<a href="/narrow/pets1_2/23">Available Produces Limit(Json output)</a>

<h2>Category these according to param</h2>
<hr>
<a href="/narrow/pets2/23">According to the Params to depart controller</a>
<a href="/narrow/pets2/23?personInfo=true">According to the Params to depart controller</a>
<br />

<h2>Use header to limit input</h2>
<hr>
<p>
    headers="Accept=application/json" -> produces="application/json"
</p>
<p>
    headers="Content-Type=application/json" --> consumes="application/json"
</p>
<a onclick="postJson2()">Headers Limit</a>
</body>
</html>
