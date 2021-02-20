<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Challenge Home Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<h3>Total characters: ${charsTotalInfo.count}</h3>
<h1>List of Characters:</h1>
<table>
    <tr>
        <th>Avatar</th>
        <th>Name</th>
        <th>Status</th>
        <th>Gender</th>
        <th>Type</th>
        <th>Species</th>
        <th>Origin</th>
        <th>Last known location</th>
    </tr>
    <#list chars as character>
        <tr>
            <td><img class="avatar" src="${character.getImage()}" alt="Avatar URL"></td>
            <td><a href="/character/${character.getId()}" target="_blank">${character.getName()}</a></td>

            <#if character.isStatusKnown()>
                <#if character.isAlive()>
                    <td><i class="fas fa-heartbeat fa-2x"></i></td>
                    <#elseif !character.isAlive()>
                        <td><i class="fas fa-skull-crossbones fa-2x"></i></td>
                </#if>
                <#else>
                    <td><i class="fas fa-question fa-2x"></i></td>
            </#if>
            <#if character.isMale()>
                <td><i class="fas fa-mars fa-2x"></i></td>
                <#else>
                    <td><i class="fas fa-venus fa-2x"></i></td>
            </#if>
             <#if character.hasType()>
                 <th>${character.getType()}</th>
                 <#else>
                     <td><i class="fas fa-minus fa-2x"></i></td>
             </#if>
            <td>${character.getSpecies()}</td>
            <#if character.isOriginKnown()>
                <td>${character.getOrigin().getName()}</td>
            <#else>
                <td><i class="fas fa-question fa-2x"></i></td>
            </#if>
             <#if character.isLastLocationKnown()>
                 <td>${character.getLocation().getName()}</td>
                 <#else>
                     <td><i class="fas fa-question fa-2x"></i></td>
             </#if>

        </tr>
    </#list>
</table>

</body>
</html>