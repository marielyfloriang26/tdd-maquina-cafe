public class MaquinaDeCafe {
    // Visibilidad de paquete: los tests acceden directamente a estos campos.
    Cafetera cafetera;
    Vaso vasosPequeno;
    Vaso vasosMediano;
    Vaso vasosGrande;
    Azucarero azucarero;

    public Cafetera getCafetera() { return cafetera; }
    public void setCafetera(Cafetera cafetera) { this.cafetera = cafetera; }
    public Vaso getVasosPequeno() { return vasosPequeno; }
    public void setVasosPequeno(Vaso vasosPequeno) { this.vasosPequeno = vasosPequeno; }
    public Vaso getVasosMediano() { return vasosMediano; }
    public void setVasosMediano(Vaso vasosMediano) { this.vasosMediano = vasosMediano; }
    public Vaso getVasosGrande() { return vasosGrande; }
    public void setVasosGrande(Vaso vasosGrande) { this.vasosGrande = vasosGrande; }
    public Azucarero getAzucarero() { return azucarero; }
    public void setAzucarero(Azucarero azucarero) { this.azucarero = azucarero; }

    /** Devuelve el depósito de vasos según el tamaño ("pequeno", "mediano" o "grande"). */
    public Vaso getTipoDeVaso(String tipoDeVaso) {
        if (tipoDeVaso == null) return null;
        switch (tipoDeVaso.toLowerCase()) {
            case "pequeno":
            case "pequeño": return vasosPequeno;
            case "mediano": return vasosMediano;
            case "grande":  return vasosGrande;
            default:        return null;
        }
    }

    /**
     * Sirve el café. Valida en orden: vasos, café y azúcar (como en el diagrama de secuencia).
     * Solo descuenta insumos si las tres validaciones pasan.
     */
    public String getVasoDeCafe(Vaso vaso, int cantidadDeVasos, int cantidadDeAzucar) {
        if (vaso == null || !vaso.hasVasos(cantidadDeVasos)) {
            return "No hay Vasos";
        }
        int cafeNecesario = vaso.getContenido() * cantidadDeVasos;
        if (!cafetera.hasCafe(cafeNecesario)) {
            return "No hay Cafe";
        }
        if (!azucarero.hasAzucar(cantidadDeAzucar)) {
            return "No hay Azucar";
        }
        vaso.giveVasos(cantidadDeVasos);
        cafetera.giveCafe(cafeNecesario);
        azucarero.giveAzucar(cantidadDeAzucar);
        return "Felicitaciones";
    }
}
