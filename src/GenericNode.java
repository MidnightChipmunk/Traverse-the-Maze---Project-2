
public class GenericNode <T> {
	
	private T nodeData;
	private GenericNode<T> nodeLink;
	
	public GenericNode(T data, GenericNode<T> link){
		nodeData = data;
		nodeLink = link;
	}
	
	public GenericNode<T> addNodeAfter(T element){
		nodeLink = new GenericNode<T>(element, nodeLink);
		
		return nodeLink;
	}
	
	public boolean removeNodeAfer(){
		
		GenericNode<T> temp = nodeLink;
		
		if(nodeLink != null){
			nodeLink = nodeLink.getLink();
		}
		
		return temp != nodeLink;
	}
	
	public int getListLength(GenericNode<T> head){
		GenericNode<T> cursor = head;
		int length = 1;
		while(cursor.getLink() != null){
			length++;
			cursor = cursor.getLink();
		}
		
		return length;
	}
	
	public static <T> int listLength(GenericNode<T> head){
		GenericNode<T> cursor = head;
		int length = 1;
		while(cursor.getLink() != null){
			length++;
			cursor = cursor.getLink();
		}
		
		return length;
	}
	
	public static <T> boolean listSearch (GenericNode<T> head, T target){ 
		GenericNode<T> cursor;
		
		for(cursor = head; cursor.getLink() != null; cursor = cursor.getLink()){
			if(target.equals(cursor.getData())){
				return true;
			}
		}
		
		return false;
	}

	public static <T> GenericNode<T> reverseList(GenericNode<T> node){
		GenericNode<T> link;
		
		if(node == null || node.getLink() == null){
			return node;
		}
		
		link = reverseList(node.getLink());
		node.getLink().setLink(node);
		
		node.setLink(null);
		
		return link;
	}
	
	private static <T> void moveHeadData(GenericNode<T> node){
		T headData = node.getData();
		
		if(node == null || node.getLink() == null){
			return;
		}
		node.setData(node.getLink().getData());
		node.getLink().setData(headData);
		GenericNode.moveHeadData(node.getLink());
	}
	
	public static <T> void reverseData(GenericNode<T> node){
		
		if(node == null || node.getLink() == null){
			return;
		}
		
		GenericNode.reverseData(node.getLink());
		GenericNode.moveHeadData(node);
	}
	
	public static <T> GenericNode<T> nodeAt(GenericNode<T> node, int position){
		int i = 1;
		GenericNode<T> cursor = node;
		
			while((i < position) && (cursor != null)){
				i++;
				cursor = cursor.getLink();
			}
			
			return cursor;
	}
	
	public void displayData(){
		GenericNode<T> cursor;
		
		for(cursor = this; cursor.getLink() != null; cursor = cursor.getLink()){
			System.out.println(cursor.getData());
		}
		System.out.println(cursor.getData());
	}
	
	@Override
	public String toString(){
		String link = null;
		String data = null;
		
		if(getLink() != null){
			link = getLink().toString();
			link = "\nLink: " + link;
		}else{
			link = "\nLink: " + link;
		}
		
		if(getData() != null){
			data = getData().toString();
			data = "\nData: " + data;
		}
		
		return data + link;
	}
	
	public T getData(){
		return nodeData;
	}
	
	public GenericNode<T> getLink(){
		return nodeLink;
	}
	
	public void setData(T data){
		nodeData = data;
	}
	
	public void setLink(GenericNode<T> link){
		nodeLink = link;
	}

}
