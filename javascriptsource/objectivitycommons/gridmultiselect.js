(function () {
    document.getElementsByTagName("body")[0].addEventListener("DOMNodeInserted", function (e) {
        if (e.target.className === "mx-dropdown dropdown-menu") {
            if (e.target.getElementsByClassName("form-control multiselect-search").length == 0) {
                var li = document.createElement("li");
                li.className = "multiselect-search-wrapper";
                var input = document.createElement("input");
                input.placeholder = "Search";
                input.className = "form-control multiselect-search";

				//clear input field
				let resetButton = document.querySelector(".mx-grid-reset-button");
				resetButton.addEventListener('click', () => {
					input.value = "";
					for (item of li.parentElement.children) {
                        item.style.display = "flex";
                    }
				});
				
                //create button clear
                let buttonClearWrapper = document.createElement("span");
                buttonClearWrapper.className = "input-group-btn";
                let buttonClear = document.createElement("button");
                buttonClear.tabIndex = "-1";
                buttonClear.className = "btn multiselect-clear-filter";
                buttonClear.addEventListener("pointerup", e => {
                    input.value = "";
                    for (item of li.parentElement.children) {
                        item.style.display = "flex";
                    }
                });
                buttonClearWrapper.appendChild(buttonClear);

                input.onkeyup = function () {
                    var filter = input.value.toUpperCase();
                    var lis = e.target.getElementsByTagName("li");
                    for (var i = 0; i < lis.length; i++) {
                        var labels = lis[i].getElementsByTagName("label");
                        if (labels.length != 0) {
                            var name = labels[0].innerHTML;
                            if (name.toUpperCase().indexOf(filter) > -1) lis[i].style.display = "flex";
                            else lis[i].style.display = "none";
                        }
                    }
                };
                li.appendChild(input);
                li.appendChild(buttonClearWrapper);
                li.addEventListener(
                    "click",
                    function (event) {
                        event.stopPropagation();
                    },
                    false,
                );
                e.target.prepend(li);
            }
        }
    });
})();
