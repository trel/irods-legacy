//      Copyright (c) 2005, Regents of the University of California
//      All rights reserved.
//
//      Redistribution and use in source and binary forms, with or without
//      modification, are permitted provided that the following conditions are
//      met:
//
//        * Redistributions of source code must retain the above copyright notice,
//      this list of conditions and the following disclaimer.
//        * Redistributions in binary form must reproduce the above copyright
//      notice, this list of conditions and the following disclaimer in the
//      documentation and/or other materials provided with the distribution.
//        * Neither the name of the University of California, San Diego (UCSD) nor
//      the names of its contributors may be used to endorse or promote products
//      derived from this software without specific prior written permission.
//
//      THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
//      IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
//      THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
//      PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
//      CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
//      EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
//      PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
//      PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
//      LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
//      NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
//      SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//
//
//  FILE
//      ProgressBarRenderer.java    -  edu.sdsc.grid.gui.applet.JTextFieldRenderer
//
//  CLASS HIERARCHY
//      java.lang.Object
//          |
//          +-.JTextFieldRenderer
//
//  PRINCIPAL AUTHOR
//      Alex Wu, SDSC/UCSD
//
//

package edu.sdsc.grid.gui.applet;

import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JComboBoxRenderer extends JComboBox implements TableCellRenderer, AppletConstant {  
    static AppletLogger logger = AppletLogger.getInstance();  
    private Color bgColor = new Color(196, 210, 227); // RGB of #c4d2e3; light blue
    
    public JComboBoxRenderer () {
        super();
        
    }
    
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column ) {
        JComboBox box = (JComboBox) value;
        // need to make sure not to add multiple listeners
        //box.addActionListener(this);
        
        if (isSelected)
            box.setBackground(new Color(196, 210, 227)); // RGB of #c4d2e3; light blue)
        else
            box.setBackground(Color.WHITE);
        
        return box;
    }  
    
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String resource = (String)cb.getSelectedItem();

    }
} 