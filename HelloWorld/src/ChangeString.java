import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ChangeString {
	public void Change(String str) {
		str = "Hello World!";
	}
	
	public static void main(String[] args) {
		String ori = "My String";
		ChangeString cs = new ChangeString();
		cs.Change(ori);
		System.out.println(ori);
		
		StringBuffer sql = new StringBuffer();
        sql.append("select (select password from t_eap_sys_user where user_id=pend_autor) psw, ");
        sql.append("(select user_name from t_eap_sys_user where user_id=pend_autor) user_name,");
        sql.append("(select user_desc from t_eap_sys_user where user_id=pend_autor) username,");
        sql.append("(select email from t_eap_sys_user where user_id=pend_autor) email,");
        sql.append("pend_autor, count(1) pendingcount ");
        sql.append(" from (select e.pend_autor ,e.process_module_name from t_eap_wf_pending e ");
        sql.append(" inner join t_eap_wf_process_runtime f on e.process_guid =f.process_guid ");
        sql.append(" where e.node_status=1 and e.pending_type<=10) t ");
        sql.append(" inner join (select  b.user_id, b.showemail,b.showemailtype,  a.app_id,a.menupage ");
        sql.append(" from (select app_id,menupage from t_cp_ui_systemapp where function_id='cpp010404') a ");
        sql.append(" join (select app_id,user_id,showemail,showemailtype from t_cp_ui_systemuserappcontrol where showemail=1 and showemailtype=1) b on (a.app_id=b.app_id)) t2 ");
        sql.append(" on (t.pend_autor=t2.user_id ) group by pend_autor");
        System.out.println(sql);
        
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
	}
}
