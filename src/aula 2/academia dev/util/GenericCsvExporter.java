package br.com.academiadev.util;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Exportador genérico de CSV usando Reflection API.
 * Aceita qualquer lista de objetos e gera CSV apenas com os campos solicitados.
 */
public class GenericCsvExporter {

    public static <T> String export(List<T> data, List<String> fields) {
        if (data == null || data.isEmpty()) return "(nenhum dado para exportar)\n";

        StringBuilder sb = new StringBuilder();

        // Cabeçalho
        sb.append(String.join(",", fields)).append("\n");

        for (T item : data) {
            for (int i = 0; i < fields.size(); i++) {
                String field = fields.get(i).trim();
                String methodName = "get" + Character.toUpperCase(field.charAt(0)) + field.substring(1);
                try {
                    Method method = item.getClass().getMethod(methodName);
                    Object value = method.invoke(item);
                    String cell = value != null ? value.toString() : "";
                    // Escapar vírgulas dentro do valor
                    if (cell.contains(",")) cell = "\"" + cell + "\"";
                    sb.append(cell);
                } catch (Exception e) {
                    sb.append("N/A");
                }
                sb.append(i < fields.size() - 1 ? "," : "\n");
            }
        }
        return sb.toString();
    }
}
