# Documentação da API
<table>
	<th>URL Base</th>
	<tr>
		<td>http://localhost:8080</td>
	</tr>
</table>

## 1. Bairros
### a. Criar bairro
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>POST</td>
			<td>/districts</td>
		</tr>
</table>

#### Request body
```javascript
{
    "district_name": "Laranjeiras",
    "value_district_m2": "400"
}
```
#### Response
Success status: `201 Created`
```javascript
{
    "district_id": 1,
    "district_name": "Laranjeiras",
    "value_district_m2": 400
}
```
<hr/>

## 2. Propriedades
### a. Criar propriedade
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>POST</td>
			<td>/properties</td>
		</tr>
</table>

#### Request body
```javascript
{
    "prop_name": "Fazenda Boa Vista",
    "prop_district_id": 1,
    "rooms": [
        {
            "room_name": "Sala de estar",
            "room_width": 20,
            "room_length": 20
        },
        {
            "room_name": "Cozinha",
            "room_width": 30,
            "room_length": 30
        }
    ]
}
```
#### Response
Success status: `201 Created`
```javascript
{
    "prop_id": 1,
    "prop_name": "Fazenda Boa Vista",
    "prop_district": "Laranjeiras",
    "value_district_m2": 400,
    "rooms": [
        {
            "room_name": "Sala de estar",
            "room_width": 20.0,
            "room_length": 20.0
        },
        {
            "room_name": "Cozinha",
            "room_width": 30.0,
            "room_length": 30.0
        }
    ]
}
```
<hr/>

### b. Calcule o total de metros quadrados de uma propriedade [US 0001]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/properties/total_m2/{propertyId}</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
    "total_m2": 1300.0
}
```
<hr/>

### c. Indique o valor de uma propriedade com base em seus cômodos e medidas [US 0002]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/properties/value/{propertyId}</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
    "value": 520000.0
}
```
<hr/>

### d. Determine qual é o maior cômodo [US 0003]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/properties/{propertyId}/largest_room</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
    "largest_room": {
        "name": "Cozinha",
        "width": 30.0,
        "length": 30.0
    }
}
```
<hr/>

### e. Determinar a quantidade de metros quadrados que tem cada cômodo de uma propriedade [US 0004]
<table>
	<th>Método</th>
	<th>Rota</th>
		<tr>
			<td>GET</td>
			<td>/properties/{propertyId}/rooms_m2</td>
		</tr>
</table>

#### Request body
```javascript
empty
```
#### Response
Success status: `200 OK`
```javascript
{
    "rooms": [
        {
            "room_name": "Sala de estar",
            "room_width": 20.0,
            "room_length": 20.0,
            "total_m2": 400.0
        },
        {
            "room_name": "Cozinha",
            "room_width": 30.0,
            "room_length": 30.0,
            "total_m2": 900.0
        }
    ]
}
```
<hr/>