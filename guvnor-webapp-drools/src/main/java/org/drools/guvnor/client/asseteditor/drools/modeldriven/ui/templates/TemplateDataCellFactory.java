/*
 * Copyright 2011 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.guvnor.client.asseteditor.drools.modeldriven.ui.templates;

import org.drools.guvnor.client.decisiontable.cells.PopupDropDownEditCell;
import org.drools.guvnor.client.widgets.drools.decoratedgrid.AbstractCellFactory;
import org.drools.guvnor.client.widgets.drools.decoratedgrid.DecoratedGridCellValueAdaptor;
import org.drools.ide.common.client.modeldriven.SuggestionCompletionEngine;

import com.google.gwt.event.shared.EventBus;

public class TemplateDataCellFactory extends AbstractCellFactory<TemplateDataColumn> {

    /**
     * Construct a Cell Factory for a specific Template Data Widget
     * 
     * @param sce
     *            SuggestionCompletionEngine to assist with drop-downs
     * @param eventBus
     *            EventBus to which cells can send update events
     */
    public TemplateDataCellFactory(SuggestionCompletionEngine sce,
                                   EventBus eventBus) {
        super( sce,
               eventBus );
    }

    /**
     * Create a Cell for the given TemplateDataColumn
     * 
     * @param column
     *            The Template Data Table model column
     * @return A Cell
     */
    public DecoratedGridCellValueAdaptor< ? extends Comparable< ? >> getCell(TemplateDataColumn column) {

        DecoratedGridCellValueAdaptor< ? extends Comparable< ? >> cell = null;

        //Check if the column has an enumeration
        String[] vals = null;
        String factType = column.getFactType();
        String factField = column.getFactField();

        //Check for enumerations
        if ( factType != null && factField != null ) {
            vals = sce.getEnumValues( factType,
                                      factField );
        }

        //Make a drop-down or plain cell
        if ( vals != null && vals.length > 0 ) {
            PopupDropDownEditCell pudd = new PopupDropDownEditCell();
            pudd.setItems( vals );
            cell = new DecoratedGridCellValueAdaptor<String>( pudd,
                                                              eventBus );

        } else {
            String dataType = column.getDataType();
            if ( column.getDataType().equals( SuggestionCompletionEngine.TYPE_BOOLEAN ) ) {
                cell = makeBooleanCell();
            } else if ( column.getDataType().equals( SuggestionCompletionEngine.TYPE_DATE ) ) {
                cell = makeDateCell();
            } else if ( dataType.equals( SuggestionCompletionEngine.TYPE_NUMERIC ) ) {
                cell = makeNumericCell();
            } else {
                cell = makeTextCell();
            }
        }

        return cell;

    }

}
