Project ini bertema tentang Asuransi. Flow project ini sangat sederhanaa, yaitu CRUD Product, CRUD Prospect, CRUD Nasabah, CRUD Vehicle, dan CRUD PolicyLife, CRUD PolicyVehicle. Database SQL yang digunakan sudah disertakan dalam project ini dengan nama Winterhold. Untuk testing, saya menggunakan Aplikasi Postman dengan URL, Method, Parameter, dan Body sebagai berikut :

1. Find All Product URL : http://localhost:8080/product , Method : GET, Parameter : -, Body : -.
2. Insert New Product URL : http://localhost:8080/product , Method : POST, Parameter : -, Body : {
    "productName": "Bugar",
    "productType": "Kesehatan",
    "frekuensi": "Bulanan",
    "paymentFee": "12000",
    "productBenefits": "untung",
    "terms": "aturan 1"
}.
3. Update Product URL :  http://localhost:8080/product?productId=9, Method : PUT, Parameter : productId, Body : {
    "productName": "Bugar",
    "productType": "Kesehatan",
    "frekuensi": "Bulanan",
    "paymentFee": 18000,
    "productBenefits": "untung",
    "terms": "aturan 1"
}.
4. Delete Product By Id URL : http://localhost7070/author/17, Method : DELETE, Parameter : productId, Body : -.
5. Find All Prospect URL : http://localhost:8080/prospect , Method : GET, Parameter : -, Body : -.
6. Insert New Prospect URL : http://localhost:8080/prospect Method : POST, Parameter : -, Body : {
    "firstName": "Asob",
    "lastName": "sobari",
    "birthDate": "1999-11-19",
    "birthPlace": "pemalang",
    "gender": "Male",
    "job": "Programmer"
}.
7. Update Prospect URL : http://localhost:8080/prospect?id=6 Method : PUT, Parameter : Id, Body : {
    "firstName": "Asob",
    "lastName": "sobari",
    "birthDate": "1999-11-19",
    "birthPlace": "Bekasi",
    "gender": "Male",
    "job": "Programmer"
  }.
8.  Delete Prospect By Id URL : [http://localhost:8080/prospect?id=5], Method : DELETE, Parameter : Id, Body : -.
10.  Find All Nasabah By Id URL : http://localhost:8080/nasabah, Method : GET, Parameter : -, Body : -.
11.  Insert Nasabah By Id URL : http://localhost:8080/nasabah?prospectId=6, Method : POST, Parameter : prospectId, Body : {
    "identityId": "3216099999888",
    "familyStatus": "Anak",
    "paymentMethod": "CC"
    }.
12.  Update Nasabah By Id URL : http://localhost:8080/nasabah?nasabahId=31/2022/6, Method : PUT, Parameter : nasabahId, Body : {
    "identityId": "3333333",
    "familyStatus": "Anak",
    "paymentMethod": "MM"
    }.
13.  Delete Nasabah By Id URL : http://localhost:8080/nasabah?nasabahId=05/2022/1, Method : DELETE, Parameter : nasabahId, Body : -.
14.  Find All Vehicle By Id URL : http://localhost:8080/vehicles, Method : GET, Parameter : -, Body : -.
15.  Insert Vehicle By Id URL : http://localhost:8080/vehicles?nasabahId=31/2022/6, Method : POST, Parameter : nasabahId, Body : {
    "vehiclePlate": "BAA9",
    "vehicleType": "Mobil",
    "vehicleRegistration": "20112",
    "vehicleBrand": "Avaanza",
    "vehicleModel": "Jazz",
    "vehicleColor": "White"
    }.
16.  Update Vehicle By Id URL : http://localhost:8080/vehicles?vehicleId=B998, Method : PUT, Parameter : vehicleId, Body : {
    "vehicleType": "Mobil",
    "vehicleRegistration": "20112",
    "vehicleBrand": "JAJAkkk",
    "vehicleModel": "Jazz",
    "vehicleColor": "White"
    }.
17.  Delete Vehicle By Id URL : http://localhost:8080/vehicles?vehicleId=BAA9, Method : DELETE, Parameter : Id, Body : -.

17.  Find All PolicyLife By Id URL : http://localhost:8080/policylife, Method : GET, Parameter : -, Body : -.
18.  Insert PolicyLife By Id URL : http://localhost:8080/policylife, Method : POST, Parameter : -, Body : {
    "productId": "life/2",
    "nasabahId": "31/2022/6",
    "insuredNasabahId": "31/2022/6"
    
}.
19.  Update PolicyLife By Id URL : http://localhost:8080/policylife?policyId=5, Method : PUT, Parameter : policyId, Body : {
    "productId": "life/2",
    "nasabahId": "31/2022/6",
    "insuredNasabahId": "05/2022/1"
    
}.
20.  Delete PolicyLife By Id URL : http://localhost:8080/policylife?policyId=5, Method : DELETE, Parameter : policyId, Body : -.

21.  Find All PolicyVehicle By Id URL : http://localhost:8080/policyvehicle, Method : GET, Parameter : Id, Body : -.
22.  Insert PolicyVehicle By Id URL : http://localhost:8080/policyvehicle, Method : POST, Parameter : Id, Body : {
    "productId": "vehicle/1",
    "vehiclePlateId": "B998"
}.
23.  Update PolicyVehicle By Id URL : http://localhost:8080/policyvehicle?policyId=2, Method : PUT, Parameter : policyId, Body : {
    "productId": "vehicle/3",
    "vehiclePlateId": "B998"
}.
 
