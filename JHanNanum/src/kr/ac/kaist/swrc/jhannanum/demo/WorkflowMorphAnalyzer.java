package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;

import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;

public class WorkflowMorphAnalyzer {

	public static void main(String[] args) throws IOException {

		Workflow workflow = WorkflowFactory
				.getPredefinedWorkflow(WorkflowFactory.WORKFLOW_MORPH_ANALYZER);
	
		String Text = "달달한 맛이 난다. 달짝지근하지만 쓴맛이 약간 가미되어있다. 부드럽고 달콤하다. 달기도하고 가끔 쓴맛이 있긴하다.\n";
		 try {
	         
	         workflow.activateWorkflow(true);

	         /* Analysis using the work flow */
	         
	         workflow.analyze(Text);	
	         System.out.println(workflow.getResultOfDocument()); 
	         workflow.close();
	         //reader.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	         System.exit(0);
	      }

	      /* Shutdown the work flow */
	      workflow.close();

	}
}
