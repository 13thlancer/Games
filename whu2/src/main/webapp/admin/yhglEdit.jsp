<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<form id="admin_yhglEdit_form" method="post">
		<table>
			<tr>
				<th>编号</th>
				<td><input name="id" readonly="readonly" />
				</td>
				<th>name</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<th>a</th>
				<td><input name="a" class="easyui-validatebox" data-options="required:true" />
				</td>
				<th>b</th>
				<td><input name="b" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>	
			<tr>
				<th>创建时间</th>
				<td><input name="createdatetime" readonly="readonly"/>
				</td>
				<th>最后修改时间</th>
				<td><input name="modifydatetime" readonly="readonly" />
				</td>
				<th></th>
				<td></td>
			</tr>
		</table>
	</form>
