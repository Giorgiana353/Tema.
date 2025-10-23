public class Report {
    private final String title, author, footer;
    private final byte[] chart;

    private Report(Builder b) {
        this.title = b.title;
        this.author = b.author;
        this.footer = b.footer;
        this.chart = b.chart;
    }

    public static class Builder {
        private String title, author, footer;
        private byte[] chart;

        public Builder title(String v) { this.title = v; return this; }
        public Builder author(String v) { this.author = v; return this; }
        public Builder footer(String v) { this.footer = v; return this; }
        public Builder chart(byte[] v) { this.chart = v; return this; }

        public Report build() { return new Report(this); }
    }

    @Override
    public String toString() {
        return "Report{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", footer='" + footer + '\'' +
               ", chart=" + (chart != null ? chart.length + " bytes" : "null") +
               '}';
    }

    public static void main(String[] args) {
        Report r = new Report.Builder()
                .title("Q3 KPIs")
                .author("BI Team")
                .footer("Confidential")
                .chart(new byte[]{})
                .build();

        System.out.println(r);
    }
}
