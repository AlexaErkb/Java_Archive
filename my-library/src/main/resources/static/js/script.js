const sortRows = (col = 'issuance') => {
    let values, i, switching, b, shouldSwitch, dir, switchcount = 0;
    values = document.getElementById("values");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    // Make a loop that will continue until no switching has been done:
    while (switching) {
    // Start by saying: no switching is done:
        switching = false;
        b = values.getElementsByClassName(col);
        rows = values.getElementsByClassName("book-row")
    // Loop through all list-items:
        for (i = 0; i < (b.length - 1); i++) {
      // Start by saying there should be no switching:
            shouldSwitch = false;
      /* Check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
            if (dir == "asc") {
            if (b[i].innerHTML > b[i + 1].innerHTML) {
          /* If next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
            shouldSwitch = true;
            break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML < b[i + 1].innerHTML) {
          /* If next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }

}

const search = () => {
    let rowName, rowPublish, rowStudentName, rowIssuance;
    let values = document.getElementsByClassName('book-row');
    let name = document.getElementById('search-by-name').value
    let publish = document.getElementById('search-by-publish').value
    let stdnt_name = document.getElementById('search-by-stdnt_name').value
    let issuance = document.getElementById('search-by-issuance').value
    for (let i = 0; i < values.length; i++){
        rowName = values[i].getElementsByClassName("name")[0].innerHTML
        rowPublish = values[i].getElementsByClassName("publish")[0].innerHTML
        rowPublish = values[i].getElementsByClassName("stdnt_name")[0].innerHTML
        rowIssuance = values[i].getElementsByClassName("issuance")[0].innerHTML.split('-').reverse().join('-')
        if (name!='' && !rowName.includes(name) || publish!='' &&!rowPublish.includes(publish) || stdnt_name!='' && !rowStudentName.includes(stdnt_name)||issuance!='' && rowIssuance != issuance) {
            values[i].style.display = 'none'
        } else {
            values[i].style.display = 'table-row'
        }
    }
}