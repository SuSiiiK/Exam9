<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=[] styles=["/css/model.css"]>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New Theme</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="form-theme">
                        <div class="mb-3">
                            <label for="recipient-name" class="col-form-label">Name:</label>
                            <input type="text" class="form-control" name="name" id="recipient-name">
                        </div>
                        <div class="mb-3">
                            <label for="message-text" class="col-form-label">Text:</label>
                            <textarea class="form-control" name="text" id="message-text"></textarea>
                        </div>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button onclick=" addTheme()" class="btn btn-primary">Crete Theme</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <div class="container" style="padding: 10px">
        <div class="list-group justify-content-center w-50 mx-auto">
            <div class="list-group-item list-group-item-action list-group-item-info d-flex justify-content-between">
                <p style="padding: 0 5px">Name</p>
                <p style="padding: 0 5px">Time</p>
                <p style="padding: 0 5px">User</p>
                <p style="padding: 0 5px">QTY</p>
            </div>
            <#list themes as theme>
                <a href="/theme/${theme.id}"
                   class="list-group-item list-group-item-action d-flex justify-content-between">
                    <p style="padding: 0 5px">${theme.name}</p>
                    <p style="padding: 0 5px">${theme.time}</p>
                    <p style="padding: 0 5px"> ${theme.user.email}</p>
                    <p style="padding: 0 5px">  ${theme.qty}</p>
                </a>
            </#list>
        </div>

        <#if user??>
            <div class="container justify-content-center mx-auto" style="padding-left: 400px">
                <button type="button" class="btn btn-primary justify-content-center pl-10 w-50 mx-auto" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">New Theme</button>
            </div>
        </#if>

        <#if 1<lastPage>
            <div class="d-flex justify-content-between w-50 mx-auto">
                <div class="justify-content-center w-50 mx-auto" style="padding: 10px">
                    <#if page!=1>
                        <a class="pageButton" style="color: black; text-align: center" href="?page=${page-1}"><<</a>
                    </#if>
                </div>
                <div class="justify-content-center w-50 mx-auto" style="padding: 10px">
                    <#list 1..pages as x>
                        <a class="pageButton" style="color: black; text-align: center" href="?page=${x}">${x}</a>
                    </#list>
                </div>
                <div class="justify-content-center w-50 mx-auto" style="padding: 10px">
                    <#if lastPage != page>
                        <a class="pageButton" style="color: black; text-align: center" href="?page=${page+1}">>></a>
                    </#if>
                </div>
            </div>
        </#if>
    </div>
</@main.renderWith>