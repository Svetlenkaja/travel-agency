function chooseTour(radio) {
    var elemdivinfo = document.getElementById('div-info');
    var elemsaved = document.getElementById('div-saved');
    var elemrest= document.getElementById('div-rest');
    if (radio.value == null)
    {
        elemdivinfo.style.display = 'none';
        elemsaved.style.display = 'block';
        document.getElementById('save-button').disabled = true;
    }
    else
    {
        document.getElementById('save-button').disabled = false;
        elemdivinfo.style.display = 'block';
        elemsaved.style.display = 'none';
        if (radio.value === 'REST')
        {
            elemrest.style.display = 'block';
        }
    }
}