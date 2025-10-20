document.addEventListener("DOMContentLoaded", function () {
  var coinFilter = document.getElementById("coinFilter");
  var coinRows = document.querySelectorAll(".coinRow");

  coinFilter.addEventListener("input", function () {
    var filter = coinFilter.value.toUpperCase();
    coinRows.forEach(function (row) {
      var coinId = row.querySelector(".coin-name").textContent.toUpperCase();
      if (coinId.indexOf(filter) > -1) {
        row.style.display = "";
      } else {
        row.style.display = "none";
      }
    });
  });
});

$(document).ready(function () {
  setInterval(function () {
    // 30 seconds
    $.ajax({
      url: "/coinlist", // Your endpoint to fetch the updated coin data
      type: "GET",
      success: function (data) {
        console.log(data);
        // Iterate over each coin to update the values
        data.forEach(function (coin, index) {
          // Find the corresponding row using index or another unique identifier
          var row = $(`tr[data-coin-id='${coin.id}']`);

          if (row.length) {
            // Update last updated timestamp
            row.find(".last-updated").text(formatDate(coin.last_updated)); // Assuming already formatted

            // Update current price
            row
              .find("td:nth-child(2)")
              .text("$" + coin.current_price.toFixed(2));

            // Update market cap
            row
              .find("td:nth-child(4)")
              .text("$" + coin.market_cap.toLocaleString());

            // Update price change
            var priceClass =
              Math.abs(coin.price_change_percentage_24h).toFixed(2) == 0.00
                ? "neutral"
                : coin.price_change_percentage_24h < 0
                ? "down"
                : "up";
            var priceChangeIcon =
              Math.abs(coin.price_change_percentage_24h).toFixed(2) == 0.00
                ? ""
                : coin.price_change_percentage_24h < 0
                ? "▼"
                : "▲";
            var priceChangeValue =
              Math.abs(coin.price_change_percentage_24h).toFixed(2) + "%";

            console.log(
              "data=" +
                priceClass +
                " " +
                priceChangeIcon +
                " " +
                priceChangeValue
            );
            // Find and update the parent span
            var priceChangeElement = row.find(".price-change");
            //console.log("priceChangeElement=" + priceChangeElement)
            priceChangeElement
              .removeClass("up down neutral")
              .addClass(priceClass)
              .html(`${priceChangeIcon} ${priceChangeValue}`);
          }
        });
      },
      error: function (err) {
        console.error("Error fetching updated coin data:", err);
      },
    });
  }, 60000); // Update every 30 seconds
});