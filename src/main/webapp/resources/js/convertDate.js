function convertDate() {
  var d = new Date('dd/MM/yyyy');
  return [d.getDate(), d.getMonth()+1, d.getFullYear()].join('/');
}