package org.aksw.autosparql.tbsl.algorithm.exploration.Utils;

import java.util.ArrayList;

import org.aksw.autosparql.tbsl.algorithm.exploration.exploration_main.Setting;

public class HeuristicSort {

	/*
	 * TODO: test if the sorted queries are given back properly
	 */
	public static ArrayList<QueryPair> doHeuristicSort(ArrayList<QueryPair> qp, String question){

		boolean change=true;
		//while(change){
			//change=false;
			for(int i = 0; i<qp.size()-1;i++){
				if(qp.get(i).getRank()==qp.get(i+1).getRank()&&(question.toLowerCase().contains("of")||question.toLowerCase().contains("which")||question.toLowerCase().contains("who"))){
					//change=true;
					QueryPair one = qp.get(i);
					QueryPair two = qp.get(i+1);
					String string = one.getQuery();
				    if(string.matches(".*\\<http://dbpedia.org/resource/.*\\> \\<http://dbpedia.org/.*\\> \\?.*")){
				    	qp.set(i, one);
						qp.set(i+1, two);

				    }
				    else{
				    	qp.set(i, two);
						qp.set(i+1, one);
				    }

				}
			}
		//}

		if(Setting.isDebugModus())DebugMode.printQueryPair(qp);

		return qp;

	}

}
