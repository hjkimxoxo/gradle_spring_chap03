package gradle_spring5_chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

	public static void main(String[] args) {
		//GenericApplicationContext도 가능(부모니까)
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		//String msg = g.greet("스프링");
		System.out.println("(g1==g2) = "+ (g1==g2));
		ctx.close();

	}

}
