package gui.model;
  
import java.util.List;
 
import javax.swing.table.AbstractTableModel;
 
import entity.Category;
import service.CategoryService;
  
public class CategoryTableModel extends AbstractTableModel {
  
    String[] columnNames = new String[] { "��������", "���Ѵ���"};
  
    // ʹ�ô�Service���ص�List��ΪTableModel������
  
    public List<Category> cs = new CategoryService().list();
  
     @Override
     public int getRowCount() {
         
        return cs.size();
    }
  
    @Override
    public int getColumnCount() {
         
        return columnNames.length;
    }
  
    @Override
    public String getColumnName(int columnIndex) {
         
        return columnNames[columnIndex];
    }
  
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
  
    // ��ͨ��cs.get(rowIndex)��ȡ�ж�Ӧ��Category����
    // Ȼ�����columnIndex���ض�Ӧ������
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h = cs.get(rowIndex);
        if (0 == columnIndex) {
            return h.name;
        }
        if (1 == columnIndex) {
            return h.recordNumber;
        }
 
        return null;
    }
  
}