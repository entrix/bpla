/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.bpla.domain;

import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name="SEQ", sequenceName = "SEQ")

@Entity
@Subselect("SELECT  detail.det_id, det_type.det_type_id, detail.state, detail.raids, det_type.det_name, det_type.det_size, det_type.det_weight\n" +
        "        FROM detail\n" +
        "        JOIN det_type ON detail.det_type_id = det_type.det_type_id")
public class Detail {
	private Long id;

    private Long    detTypeId;
	private String  state;
	private Integer raids;

    private String  name;
    private Integer weight;
    private String  size;

    private Set<Bpla> bplas = new HashSet();

	public Detail() {
		// this form used by Hibernate
	}

    public Detail(Long id) {
        this.setId(id);
    }
    
    @ManyToMany
    public Set<Bpla> getBplas() {
        return bplas;
    }

    public void setBplas(Set bplas) {
        this.bplas = bplas;
    }


    @Column(name = "det_size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name = "det_weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "det_name")
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "raids")
    public Integer getRaids() {
        return raids;
    }

    public void setRaids(Integer raids) {
        this.raids = raids;
    }

    @Column(name = "state")
    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "det_type_id")
    public Long getDetTypeId() {

        return detTypeId;
    }

    public void setDetTypeId(Long detTypeId) {
        this.detTypeId = detTypeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @Column(name = "det_id")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        if (id < 0) {
            //value is not possible
            return;
        }

        this.id = id;
    }
}