<div class="modal fade" id="editPost" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action="/edit-post" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="post_id" value="<%=post.getId()%>"> <!--часто используемая всеми имба фигня для того чтобы узнать сразу же допустим ID для сервлета при EDIT, особеннов в ВК -->
                    <div class="row">
                        <div class="col-12">
                            <label>Author:</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="post_author" value="<%=post.getAuthor()%>">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <label>Image:</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">

<%--                            <input type="file" class="form-control mt-3" name="post_image" accept="image/*">--%>
                            <input type="file" class="form-control" name="post_image" value="<%=post.getImageUrl()%>" accept="image/*"  >
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>DESCRIPTION : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <textarea name="post_description" class="form-control" rows="10" ><%=post.getDescription()%></textarea>
                        </div>
                    </div>


                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-primary">SAVE POST</button>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>