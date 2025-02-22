package models;

/**
 * Ticket tiplerini belirleyen enum.
 */
public enum TicketType {
    VIP,
    USUAL,
    BUDGETARY,
    CHEAP;

    /**
     * Enum elemanlarını virgülle ayrılmış bir string olarak döndürür.
     */
    public static String names() {
        StringBuilder sb = new StringBuilder();
        for(TicketType t : TicketType.values()){
            sb.append(t.name()).append(", ");
        }
        return sb.substring(0, sb.length()-2);
    }
}
