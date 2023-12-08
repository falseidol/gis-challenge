// Map initialize

var map = L.map('map', {
    center: [60.0, 31.0],
    minZoom: 2,
    zoom: 6,
    maxBounds: 3857
});

map.fitBounds([
    [40, -74.227],
    [0, -74.125]
]);

async function fetchDataFromServer() {
    // Отправляем GET-запрос на сервер
    const response = await fetch('http://localhost:8083/getPolygons');

    // Получаем данные из тела ответа в формате JSON
    const data = await response.json();
    console.log(data)
    const massiv = data.map((polygon) => {
        return {
            points: polygon.polygon.points.map((point) => {
                return Object.values(point)
            }), color: polygon.color
        }
    })
    console.log(massiv)
    massiv.map((x) => {
        var polygon = L.polygon(x.points, {color: x.color}).addTo(map);
    })
}

const forma = document.querySelector("form");
forma.addEventListener("submit", submitForm)

function submitForm(event) {
    event.preventDefault();
    const a = document.getElementById("width").value;
    const b = document.getElementById("height").value;
    const z = L.latLng(a, b);
    map.panTo(z)
    fetchDataFromServer();

}


L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    subdomains: ['a', 'b', 'c']
}).addTo(map);
var controlLoader = L.control.loader().addTo(map);
