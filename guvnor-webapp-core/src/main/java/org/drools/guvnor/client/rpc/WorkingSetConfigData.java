/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.rpc;

import java.io.Serializable;
import java.util.List;

import org.drools.ide.common.client.modeldriven.brl.PortableObject;
import org.drools.ide.common.client.factconstraints.ConstraintConfiguration;
import org.drools.ide.common.client.factconstraints.customform.CustomFormConfiguration;

public class WorkingSetConfigData implements PortableObject, Serializable {
    private static final long serialVersionUID = 510l;

    public String name;
    public String description;
    public List<ConstraintConfiguration> constraints;
    public List<CustomFormConfiguration> customForms;

    public String[] validFacts;
    public WorkingSetConfigData[] workingSets;
}
