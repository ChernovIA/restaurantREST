<p># restaurantREST</p>

<p>API documentation</p>

<p>*Standart administrator has login admin and password adminPass.</p>

<p>**All url begin with you {server_name}/API_url</p>

<table border="1" cellpadding="1" cellspacing="1" style="width:900px">
	<tbody>
		<tr>
			<td style="text-align:center">API url</td>
			<td style="text-align:center">Method</td>
			<td style="text-align:center">Permission</td>
			<td style="text-align:center">Description</td>
			<td style="text-align:center">Param</td>
			<td style="text-align: center; width: 200px;">Result</td>
		</tr>
		<tr>
			<td colspan="6" style="text-align:center"><strong>Users</strong></td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/user</strong></td>
			<td style="text-align:center">GET</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">get list of users</td>
			<td>&nbsp;</td>
			<td>[<br />
			&nbsp; &nbsp; {<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 1,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;name&quot;: &quot;admin&quot;<br />
			&nbsp; &nbsp; },<br />
			&nbsp; &nbsp; {<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;name&quot;: &quot;user&quot;<br />
			&nbsp; &nbsp; }<br />
			]</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/user</strong></td>
			<td style="text-align:center">POST</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">&nbsp;create new user</td>
			<td>
			<p style="text-align:center">name,</p>
			<p style="text-align:center">password</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &quot;name&quot;: &quot;usr&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/user</strong></td>
			<td style="text-align:center">PUT</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">update user</td>
			<td style="text-align:center">
			<p style="text-align:center">id, name,</p>
			<p style="text-align:center">password</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &quot;name&quot;: &quot;new_user&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/user/{id}</strong></td>
			<td style="text-align:center">DELETE</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">delete user</td>
			<td style="text-align:center">&nbsp;url param {id}</td>
			<td style="text-align:center">ОК</td>
		</tr>
		<tr>
			<td colspan="6" style="text-align:center"><strong>Dishes</strong></td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/dish</strong></td>
			<td style="text-align:center">GET</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">get list of dishes</td>
			<td>&nbsp;</td>
			<td>[<br />
			&nbsp; &nbsp; {<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 1,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;name&quot;: &quot;Nuddles&quot;<br />
			&nbsp; &nbsp; },<br />
			&nbsp; &nbsp; {<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;name&quot;: &quot;Sup&quot;<br />
			&nbsp; &nbsp; }<br />
			]</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/dish</strong></td>
			<td style="text-align:center">POST</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">&nbsp;create new dish</td>
			<td>
			<p style="text-align:center">name</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &quot;name&quot;: &quot;Sup&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/dish</strong></td>
			<td style="text-align:center">PUT</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">update dish</td>
			<td style="text-align:center">
			<p style="text-align:center">id, name</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &quot;name&quot;: &quot;Pizza&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/dish/{id}</strong></td>
			<td style="text-align:center">DELETE</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">delete dish</td>
			<td style="text-align:center">&nbsp;url param {id}</td>
			<td style="text-align:center">ОК</td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td colspan="6" style="text-align:center"><strong>Restaurants</strong></td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/restaurant</strong></td>
			<td style="text-align:center">GET</td>
			<td style="text-align:center">admin, user</td>
			<td style="text-align:center">get list of restaurans</td>
			<td>&nbsp;</td>
			<td>[<br />
			&nbsp; &nbsp; {<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 1,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;name&quot;: &quot;PizzaHat&quot;<br />
			&nbsp; &nbsp; },<br />
			&nbsp; &nbsp; {<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;name&quot;: &quot;Karl-fridrih&quot;<br />
			&nbsp; &nbsp; }<br />
			]</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/restaurant</strong></td>
			<td style="text-align:center">POST</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">&nbsp;create new restauran</td>
			<td>
			<p style="text-align:center">name</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &quot;name&quot;: &quot;Karl-fridrih&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/restaurant</strong></td>
			<td style="text-align:center">PUT</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">update restauran</td>
			<td style="text-align:center">
			<p style="text-align:center">id, name</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &quot;name&quot;: &quot;Crazy hunter&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/restaurant/{id}</strong></td>
			<td style="text-align:center">DELETE</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">delete restauran</td>
			<td style="text-align:center">&nbsp;url param {id}</td>
			<td style="text-align:center">ОК</td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td colspan="6" style="text-align:center"><strong>Menu</strong></td>
		</tr>
		<tr>
			<td style="text-align:center">
			<p><strong>/rest/menu/restaurant/</strong></p>
			<p><strong>{restaurantId}/date/{localDate}</strong></p>
			</td>
			<td style="text-align:center">GET</td>
			<td style="text-align:center">admin, user</td>
			<td style="text-align:center">get list of dishes from restaurant menu</td>
			<td>
			<p style="text-align:center">restaurantId,</p>
			<p style="text-align:center">localDate (&quot;dd.mm.yyyy&quot;)</p>
			</td>
			<td>
			<p>[<br />
			&nbsp; &nbsp;{<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 1,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;date&quot;: &quot;2019-01-07&quot;,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;restaurant&quot;: &quot;PizzaHat&quot;,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;dish&quot;: &quot;Pizza&quot;,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;price&quot;: 500<br />
			&nbsp; &nbsp;,<br />
			&nbsp; &nbsp;<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;date&quot;: &quot;2019-01-07&quot;,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;restaurant&quot;: &quot;PizzaHat&quot;,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;dish&quot;: &quot;Sup&quot;,<br />
			&nbsp; &nbsp; &nbsp; &nbsp; &quot;price&quot;: 100<br />
			&nbsp; &nbsp;}</p>
			<p>]</p>
			</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/menu</strong></td>
			<td style="text-align:center">POST</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">&nbsp;create new dish in menu</td>
			<td>
			<p style="text-align:center">restaurantId,</p>
			<p style="text-align:center">dishId,</p>
			<p style="text-align:center">localDate,</p>
			<p style="text-align:center">price</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 1,<br />
			&nbsp; &nbsp; &quot;date&quot;: &quot;2019-01-07&quot;,<br />
			&nbsp; &nbsp; &quot;restaurant&quot;: &quot;PizzaHat&quot;,<br />
			&nbsp; &nbsp; &quot;dish&quot;: &quot;Pizza&quot;,<br />
			&nbsp; &nbsp; &quot;price&quot;: 500<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/menu</strong></td>
			<td style="text-align:center">PUT</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">update dish in menu</td>
			<td style="text-align:center">
			<p style="text-align:center">id,</p>
			<p style="text-align:center">restaurantId,</p>
			<p style="text-align:center">dishId,</p>
			<p style="text-align:center">localDate,</p>
			<p style="text-align:center">price</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 2,<br />
			&nbsp; &nbsp; &quot;name&quot;: &quot;Crazy hunter&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center"><strong>/rest/menu/{id}</strong></td>
			<td style="text-align:center">DELETE</td>
			<td style="text-align:center">admin</td>
			<td style="text-align:center">delete dish from menu</td>
			<td style="text-align:center">&nbsp;url param {id}</td>
			<td style="text-align:center">ОК</td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td colspan="6" style="text-align:center"><strong>Votes</strong></td>
		</tr>
		<tr>
			<td style="text-align:center">
			<p><strong>/rest/votes/vote/restaurant/</strong></p>
			<p><strong>{restaurantId}</strong></p>
			</td>
			<td style="text-align:center">GET</td>
			<td style="text-align:center">admin, user</td>
			<td style="text-align:center">add vote to restaurant</td>
			<td>
			<p style="text-align:center">restaurantId</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;id&quot;: 1,<br />
			&nbsp; &nbsp; &quot;date&quot;: &quot;2019-01-07&quot;,<br />
			&nbsp; &nbsp; &quot;user&quot;: &quot;usr&quot;,<br />
			&nbsp; &nbsp; &quot;restaurant&quot;: &quot;PizzaHat&quot;<br />
			}</td>
		</tr>
		<tr>
			<td style="text-align:center">
			<p style="text-align:center"><strong>/rest/votes/statistic/restaurant/</strong></p>
			<p style="text-align:center"><strong>{restaurantId}/date/{localDate}</strong></p>
			</td>
			<td style="text-align:center">POST</td>
			<td style="text-align:center">admin, user</td>
			<td style="text-align:center">&nbsp;get restaurant rate</td>
			<td>
			<p style="text-align:center">restaurantId,</p>
			<p style="text-align:center">localDate</p>
			</td>
			<td>{<br />
			&nbsp; &nbsp; &quot;localDate&quot;: &quot;2019-01-08&quot;,<br />
			&nbsp; &nbsp; &quot;restaurant&quot;: &quot;PizzaHat&quot;,<br />
			&nbsp; &nbsp; &quot;rate&quot;: 75.15<br />
			}</td>
		</tr>
		<tr>
		</tr>
	</tbody>
</table>
