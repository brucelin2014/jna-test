package test_jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class test {
	public interface Dll extends Library{
		Dll instance = (Dll)Native.loadLibrary("dev_printer", Dll.class);
		
		public int init_dev(String dev, String prt_cfg);
		public int dev_oper(String dev, String cmd);
		public int get_dev_status(String dev, int status);
		public int printer_version();
	}
	
	public static void main(String[]args)
	{
		String dev = "<?xml version = \"1.0\" encoding=\"UTF-8\"?><dev><dev_id>GP-58MBIII</dev_id><dev_type>3</dev_type><dev_host_addr></dev_host_addr><dev_addr>com7,9600,99</dev_addr><dev_addr_type>1</dev_addr_type><dev_model></dev_model></dev>";
		
		String prt_cfg = "00|00|00|YYYY-MM-DD|hh:mm:ss|C:\\printer_test\\CCB Asia LOGO 800X121.png|黑体,00|黑体,00|黑体,22|黑体,00|黑体,00|黑体,00|黑体,00|黑体,00|" +
"@PRINT_TYPE4@PRINT_CENTER歡迎光臨@CMD_CRLF" +
"@PRINT_TYPE4@PRINT_CENTERWelcome to@CMD_CRLF" +
"@PRINT_TYPE4@PRINT_CENTER九龍灣建行中心分行@CMD_CRLF" +
"@PRINT_CENTERJIULONGWAN Construction Bank Central@CMD_CRLF" +
"@PRINT_TYPE3@PRINT_CENTER@print_cnumber@CMD_CRLF" +
"@PRINT_TYPE4@CMD_SP@CMD_SP服務名稱:@CMD_SP@PRINT_TYPE5@print_type@CMD_CRLF" +
"@PRINT_TYPE4@CMD_SP@CMD_SPService Type:@CMD_SP@PRINT_TYPE5@print_type@CMD_CRLF" +
"@CMD_SP@CMD_SP@PRINT_TYPE4前面有:@CMD_SP@PRINT_TYPE5@print_count@CMD_SP@PRINT_TYPE4，請稍後。@CMD_CRLF" +
"@CMD_SP@CMD_SPNumber of People Waiting:@print_count@CMD_SP,Please wait to be served@CMD_CRLF" +
"@CMD_SP@CMD_SP@CMD_SP@CMD_SP@CMD_SP@CMD_SP@PRINT_TYPE4@print_date@CMD_SP@CMD_SP@print_time@CMD_CRLF" +
"@CMD_SP@CMD_SP??????!@CMD_CRLF" +
"@CMD_CRLF" +
"@CMD_CRLF" +
"@CMD_SP@CMD_SP@CMD_SP@CMD_SP@CMD_SP@CMD_SP@PRINT_TYPE4??????!@CMD_CRLF" +
"@CMD_CRLF" +
"@CMD_SP@CMD_SP@CMD_SP@CMD_SP@CMD_SP@CMD_SP@PRINT_TYPE4@print_msg@CMD_CRLF" +
"@CMD_CRLF" +
"@PRINT_CENTER@CMD_SP@CMD_SP@PRINT_LOGO";
		
		String cmd = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><cmd><cmd_name>PRINTNUM</cmd_name><cmd_data>A002|20|自定义类型 custom type|@PRINT_TYPE1您是我行信用卡推荐@PRINT_TYPE4尊贵客户，@PRINT_TYPE1请联系大堂经理！|D:\\CCBQSDriver\\print data\\CCB Asia LOGO.bmp|您的星级为★★★✰✰✰✰</cmd_data><show_type_list>03|07|03|05</show_type_list><show_switch_time>3000</show_switch_time><show_align>1</show_align><font>1</font><font_size>16</font_size></cmd>";
		
		System.out.println("init_dev " + Dll.instance.init_dev(dev, prt_cfg));
		System.out.println("dev_oper " + Dll.instance.dev_oper(dev, cmd));
		System.out.println("printer_version " + Dll.instance.printer_version());
	}
	
}
