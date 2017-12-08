package NLPIRAnalyer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;



public class Test{
	public static void main(String[] args) throws IOException {
		String seperator="|";
		String text="基于java语言开发的轻量级的中文分词工具包";
		//Analyzer analyzer=new SimpleAnalyzer();
		Analyzer analyzer=new NLPIRAnalyzer();
		
		StringBuffer sb=new StringBuffer();
	    //分词
		TokenStream ts=analyzer.tokenStream("ss", new StringReader(text));
		ts.reset();
		CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
		OffsetAttribute offset=ts.getAttribute(OffsetAttribute.class);

		while(ts.incrementToken()){
			sb.append(term.toString()+offset.startOffset()+":"+offset.endOffset()+seperator);
		}
		System.out.println(sb.toString());
		ts.end();
		ts.close();
		analyzer.close();
	}

}
