<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${userInfo.nickname}</title>
</head>
<body>
<div style="text-align:center"><h1>这就是你点击同意之后我获取到的你的信息</h1></div>
<div style="text-align:center"><h1>哈哈哈哈哈哈哈哈哈</h1></div>

<h2>昵称:${userInfo.nickname}</h2>
<h2>国家:${userInfo.country}</h2>
<h2>省份:${userInfo.province}</h2>
<h2>城市:${userInfo.city}</h2>
<h2>唯一标识:${userInfo.openid}</h2>
<h2>性别:
    <#if userInfo.sex == 1>
        男
    <#elseif userInfo.sex == 2>
        女
    <#elseif userInfo.sex == 0>
        未知
    </#if>
</h2>
<h2>头像:<img src="${userInfo.headimgurl}"></h2>
</body>
</html>