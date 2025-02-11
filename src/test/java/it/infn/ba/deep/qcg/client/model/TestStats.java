/*
 * Copyright © 2019 I.N.F.N.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.infn.ba.deep.qcg.client.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class TestStats {

    @Test
    public void test() {
        
        Stats S = new Stats();
        
        //default values
        assertTrue(S.getTotal()==null);        
        assertTrue(S.getStates()==null);
        
        Stats S1 = new Stats();
        
        Map<String,Integer> total = new HashMap<String,Integer>();
        total.put("k1", 1);
        
        Map<String,Integer> states = new HashMap<String,Integer>();
        states.put("k2", 2);
        
        S1.setTotal(total);
        S1.setStates(states);
        
        assertTrue(S1.getTotal().equals(total));
        assertTrue(S1.getStates().equals(states));
        
        S1.toString();
        
        Stats S2 = new Stats(total,
                             states);
        
        assertTrue(S2.getTotal().equals(total));
        assertTrue(S2.getStates().equals(states));
        
    }
}
