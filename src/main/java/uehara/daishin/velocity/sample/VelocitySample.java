package uehara.daishin.velocity.sample;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import lombok.val;

public class VelocitySample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("実行開始");
		Velocity.init(); // Velocityの初期化
		val vcontext = new VelocityContext(); // コンテキストの生成

		// テンプレート表示に用いるコンテキストを格納
		vcontext.put("name", new String("Velocity"));
		Template vtemplate = null;

		try {
			vtemplate = Velocity.getTemplate("template/sample01.vm");
		} catch (ResourceNotFoundException rnfe) {
			// テンプレートがみつからない

		} catch (ParseErrorException pee) {
			// 構文エラー : テンプレートの解析時に問題発生
		} catch (MethodInvocationException mie) {
			// テンプレートのどこかで例外が投げられた
		} catch (Exception e) {
		}

		val sw = new StringWriter();

		vtemplate.merge(vcontext, sw);

		System.out.println("実行終了");
	}

}
