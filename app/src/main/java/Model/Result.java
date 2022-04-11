package Model;

import java.util.List;

public class Result{
	private List<ResultItem> result;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}