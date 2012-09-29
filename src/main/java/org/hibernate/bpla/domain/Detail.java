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
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name="SEQ", sequenceName = "SEQ")

@Entity
@Subselect("SELECT  detail.det_id, det_type.det_type_id as det_type_id, detail.state as state, detail.raids as raids, det_type.det_name as name, det_type.det_size as size, det_type.det_weight as weight\n" +
        "        FROM detail\n" +
        "        JOIN det_type ON detail.det_type_id = det_type.det_type_id")
@Synchronize( {"detail", "det_type"} )
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

    public Detail(SubDetail subDetail, SubDetType subDetType) {
        this.id = subDetail.getId();
        this.detTypeId = subDetType.getId();
        this.raids = subDetail.getRaids();
        this.state = subDetail.getState();
        this.name = subDetType.getName();
        this.weight = subDetType.getWeight();
        this.size = subDetType.getSize();
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="aggregate",
            joinColumns=
            @JoinColumn(name="det_id", referencedColumnName="det_id"),
            inverseJoinColumns=
            @JoinColumn(name="bpla_id", referencedColumnName="bpla_id")
    )
    public Set<Bpla> getBplas() {
        return bplas;
    }

    public void setBplas(Set bplas) {
        this.bplas = bplas;
    }


    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "name")
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