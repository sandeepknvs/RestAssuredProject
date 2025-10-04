package session12;

public class InvoiceSettings {
	private Object custom_fields;
    private Object default_payment_method;
    private Object footer;
    private Object rendering_options;

	 	public Object getCustom_fields() {
		return custom_fields;
	}
	public Object getDefault_payment_method() {
		return default_payment_method;
		
	}
	public Object getFooter() {
		return footer;
	}
	public Object getRendering_options() {
		return rendering_options;
	}
		private void setCustom_fields(Object custom_fields) {
		this.custom_fields = custom_fields;
	}
	private void setDefault_payment_method(Object default_payment_method) {
		this.default_payment_method = default_payment_method;
	}
	private void setFooter(Object footer) {
		this.footer = footer;
	}
	private void setRendering_options(Object rendering_options) {
		this.rendering_options = rendering_options;
	}
		

}
