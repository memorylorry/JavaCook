<html>
<header>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script>
        function loginSubmit(){
            var data = {"name": "root","passwd":123451};
            $.ajax({
                type: "POST",
                url: "/http/postBody",
                data: data,
                success: function (message) {
                    alert(JSON.stringify(message));
                },
                error: function (message) {
                    alert(JSON.stringify(message));
                }
            });
        }
    </script>
</header>
<body>
<h2>GET Params</h2>
<a href="/http/rawGetParam?name=tom">rawGetParam</a>
<a href="/http/getParam?name=hell">getParam</a>
<a href="/http/getParams?name=root&passwd=123456">getParams</a>
<a onclick="loginSubmit()">postBody</a>
<h2>GET Headers</h2>
<a href="/http/requestHeader">requestHeader</a>
<a href="/http/requestHeaders">requestHeaders</a>
<h2>GET Cookies</h2>
<a href="/http/getCookie">requestHeader</a>
<a href="/http/getCookies">requestHeaders</a>
<h2>GET Sessions</h2>
<a href="/session?method=index1">addSessionAttrs</a>
<a href="/session?method=index2">getSessionsOneByOne</a>
<a href="/session?method=index3">getSessionsMap</a>
<a href="/session?method=index4">getSessionAttrRaw</a>
<a href="/session?method=index5">CloseSession</a>
<h2>Upload File</h2>
<a href="./upload.jsp">Upload</a>
</body>
</html>
