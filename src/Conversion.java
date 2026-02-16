public class Conversion {
    private double monto;
    private String monedaBase;
    private String monedaDestino;
    private double resultadoConversion;

    public Conversion(ConversionApi miConversionApi,double monto){
        this.monto = monto;
        this.monedaBase = miConversionApi.base_code();
        this.monedaDestino = miConversionApi.target_code();
        this.resultadoConversion = miConversionApi.conversion_result();
    }

    @Override
    public String toString() {
        return "Conversión de "+monto+" ["+monedaBase+"] -> "+resultadoConversion+" ["+monedaDestino+"]";
    }
}
