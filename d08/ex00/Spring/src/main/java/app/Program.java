package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import preprocessor.PreProcessor;
import preprocessor.PreProcessorToUpperImpl;
import printer.Printer;
import printer.PrinterWithPrefixImpl;
import render.Renderer;
import render.RendererErrImpl;

public class Program {
        public static void main(String[] args) {
//            PreProcessor preProcessor = new PreProcessorToUpperImpl();
//            Renderer renderer = new RendererErrImpl(preProcessor);
//            PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
//            printer.setPrefix ("Prefix ");
//            printer.print ("Hello!") ;
            ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
            Printer printer = context.getBean("printerWithPrefix", Printer.class);
            printer.print ("Hello!") ;
        }
}
