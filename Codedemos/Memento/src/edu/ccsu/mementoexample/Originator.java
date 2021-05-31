package edu.ccsu.mementoexample;

/**
 * Simple example of Memento pattern for saving state to be held
 * by another class safely without breaking encapsulation.
 * 
 * @author Chad Williams
 */
public class Originator {
    private String transferrableInfo;
    private String valueNotInMemento;
    
    public Originator(){
    }
    
    public Originator(Memento memento) {
    	this.transferrableInfo = memento.transferrableInfo;
    }
    
    public Originator(String valueNotInMemento, String transferrableInfo){
        this.valueNotInMemento = valueNotInMemento;
        this.transferrableInfo = transferrableInfo;
    }
    
    public String toString(){
        return "Originator(transferrableInfo: "+transferrableInfo+"  valueNotInMemento: "+valueNotInMemento+")";
    }
    
    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setTransferrableInfo(this.transferrableInfo);
        return memento;
    }
    
    public void restoreFromMemento(Memento memento){
        this.transferrableInfo = memento.getTransferrableInfo();
    }
    
    public static class Memento{
        private String transferrableInfo;
        private Memento(){
            
        }
        
        private void setTransferrableInfo(String transferrableInfo){
            this.transferrableInfo = transferrableInfo;
        }
        
        private String getTransferrableInfo(){
            return transferrableInfo;
        }
    }
}
