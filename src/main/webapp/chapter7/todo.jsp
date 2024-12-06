<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプルTodoリスト</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.todo-container {
	width: 50%;
	margin: auto;
	margin-top: 50px;
}

.todo-form {
	display: flex;
	justify-content: space-between;
	margin-bottom: 20px;
}

.todo-form input[type="text"] {
	width: 80%;
	padding: 10px;
	font-size: 16px;
}

.todo-form input[type="submit"] {
	padding: 10px 20px;
	font-size: 16px;
}

.todo-list {
	list-style-type: none;
	padding: 0;
}

.todo-list li {
	padding: 10px;
	border-bottom: 1px solid #ccc;
}

.delete-button {
	float: right;
	background-color: #ff4d4d;
	border: none;
	color: white;
	padding: 5px 10px;
	cursor: pointer;
}
</style>
</head>
<body>
	<%
	// セッションからTodoリストを取得または新規作成
	List<String> todoList = (List<String>) session.getAttribute("todoList");
	if (todoList == null) {
		todoList = new ArrayList<String>();
		session.setAttribute("todoList", todoList);
	}

	String action = request.getParameter("action");
	if ("add".equals(action)) {
		String newTodo = request.getParameter("todo");
		if (newTodo != null && !newTodo.trim().isEmpty()) {
			todoList.add(newTodo.trim());
		}
	} else if ("delete".equals(action)) {
		String indexStr = request.getParameter("index");
		if (indexStr != null) {
			try {
		int index = Integer.parseInt(indexStr);
		if (index >= 0 && index < todoList.size()) {
			todoList.remove(index);
		}
			} catch (NumberFormatException e) {
		// インデックスが無効な場合は無視
			}
		}
	}
	%>
	<div class="todo-container">
		<h1>Todoリスト</h1>
		<form class="todo-form" method="POST" action="todo.jsp">
			<input type="hidden" name="action" value="add"> <input
				type="text" name="todo" placeholder="新しいTodoを入力" required> <input
				type="submit" value="追加">
		</form>
		<ul class="todo-list">
			<%
			for (int i = 0; i < todoList.size(); i++) {
				String todo = todoList.get(i);
			%>
			<li><%=todo%>
				<button class="delete-button" onclick="deleteItem(<%=i%>)">削除</button>
			</li>
			<%
			}
			if (todoList.isEmpty()) {
			%>
			<li>現在、Todoはありません。</li>
			<%
			}
			%>
		</ul>
	</div>
</body>
</html>
<script>
        function deleteItem(index) {
            if(confirm("本当にこのTodoを削除しますか？")) {
                // フォームを作成して送信
                var form = document.createElement("form");
                form.method = "POST";
                form.action = "todo.jsp";

                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "action";
                input.value = "delete";

                var indexInput = document.createElement("input");
                indexInput.type = "hidden";
                indexInput.name = "index";
                indexInput.value = index;

                form.appendChild(input);
                form.appendChild(indexInput);
                document.body.appendChild(form);
                form.submit();
            }
        }
</script>

