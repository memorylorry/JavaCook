
## SpringDemos5
These are some simple demos for fresher. You could refer to them to know spring mvc.

## Content
 <a href="./src/HelloWorld">HelloWorld</a><br>
 <a href="./src/HelloWorld2">HelloWorld2</a><br>
 <a href="./src/MVCFrame">MVCFrame</a><br>
 <a href="./src/SpringBootBaisc">SpringBootBaisc</a><br>
 <a href="./src/SpringSecurityBasic">SpringSecurityBasic</a><br>
 <a href="./src/URIPatterns">URIPatterns</a><br>
 <a href="./src/MsgConverterBasic">MsgConverterBasic</a><br>
 <a href="./src/HTTPHandlerMethod">HTTPHandlerMethod</a><br>
 <a href="./src/ViewerResolver">ViewerResolver</a><br>
 <a href="./src/SecurityJDBCLoginDemo">SecurityJDBCLoginDemo</a><br>

## Clone Demos which you wanna get
<img src="./assets/GitCloneSubTree.gif" />

### Guide to git One Directory from your git resposibilty
1. Locate one NULL directory. And init git resposibilty: 
> git init
2. This creates an empty repository with your remote, and fetches all objects but doesn't check them out:
> git remote add -f origin https://github.com/memorylorry/SpringDemos5.git
3. Then do:
> git config core.sparseCheckout true

> echo "MVCFrame" >> .git/info/sparse-checkout

> echo "someDirYourWannaGet" >> .git/info/sparse-checkout
4. Finally, Pull it:
> git pull origin master

Now you could see which directories your wanna pull is here! Check out it.
